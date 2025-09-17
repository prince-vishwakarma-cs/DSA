class Food {
    String name;
    String cuisine;
    int rating;
    
    Food(String name, String cuisine, int rating) {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
    }
}

class FoodRatings {
    private Map<String, Food> foodMap;
    private Map<String, TreeSet<Food>> cuisineMap; 

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        cuisineMap = new HashMap<>();
        
        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], food);
            
            cuisineMap.computeIfAbsent(cuisines[i], k -> 
                new TreeSet<>((a, b) -> {
                    if (a.rating != b.rating) {
                        return Integer.compare(b.rating, a.rating);
                    }
                    return a.name.compareTo(b.name);
                })
            ).add(food);
        }
    }
    
    public void changeRating(String foodName, int newRating) {
        Food food = foodMap.get(foodName);
        TreeSet<Food> cuisineSet = cuisineMap.get(food.cuisine);
        
        cuisineSet.remove(food);
        food.rating = newRating;
        cuisineSet.add(food);
    }
    
    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first().name;
    }
}