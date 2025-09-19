class Spreadsheet {
    Map<String,Integer> mp;
    int s;

    public Spreadsheet(int rows) {
        mp=new HashMap<>();
        s=rows;
    }
    
    public void setCell(String cell, int value) {
        mp.put(cell,value);
    }
    
    public void resetCell(String cell) {
        mp.put(cell,0);
    }
    
    public int getValue(String formula) {
        String new_formula = formula.substring(1,formula.length());
        String[] cells = new_formula.split("\\+");
        int num1 = cells[0].matches("-?\\d+") ? Integer.parseInt(cells[0]) : mp.getOrDefault(cells[0],0);
        int num2 = cells[1].matches("-?\\d+") ? Integer.parseInt(cells[1]) : mp.getOrDefault(cells[1],0);
        return num1+num2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */