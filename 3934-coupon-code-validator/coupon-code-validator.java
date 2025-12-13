class Coupon {
    String code;
    String businessLine;

    Coupon(String code,String businessLine) {
        this.code=code;
        this.businessLine=businessLine;
    }
}

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        ArrayList<Coupon> res=new ArrayList<>();
        for(int i=0;i<code.length;i++){
            int check=0;
            int l=code[i].length();
            if(l!=0){
                int count=0;
                for(char c:code[i].toCharArray()){
                    if(Character.isLetterOrDigit(c) || c=='_'){
                        count+=1;
                    }
                }
                if(count==l) check+=1;
            }
            HashSet<String> b=new HashSet<>();
            b.add("electronics");
            b.add("grocery");
            b.add("pharmacy");
            b.add("restaurant");
            if(b.contains(businessLine[i])) check+=1;
            if(isActive[i]) check+=1;

            if(check==3){
                res.add(new Coupon(code[i],businessLine[i]));
            }
        }
        Map<String,Integer> priority=new HashMap<>();
        priority.put("electronics",0);
        priority.put("grocery",1);
        priority.put("pharmacy",2);
        priority.put("restaurant",3);

        Collections.sort(res,(a,b)->{
            int p1=priority.get(a.businessLine);
            int p2=priority.get(b.businessLine);

            if(p1!=p2) {
                return p1-p2;
            }
            return a.code.compareTo(b.code);
        });

        List<String> result=new ArrayList<>();
        for (Coupon c:res) {
            result.add(c.code);
        }
        return result;

    }
}