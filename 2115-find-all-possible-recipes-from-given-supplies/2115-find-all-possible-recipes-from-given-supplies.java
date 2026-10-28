class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        List<String> ans = new ArrayList<>();
        Map<String,Boolean> canMake = new HashMap<>();
        Map<String,Integer> recipeToIndex = new HashMap<>();

        for(String s : supplies){
            canMake.put(s,true);
        }
        for(int i=0;i<n;i++)
            recipeToIndex.put(recipes[i],i);
        
        for(String rec : recipes){
            checkRecipe(rec , ingredients, new HashSet<String>(),canMake,recipeToIndex);
            if(canMake.get(rec))
                ans.add(rec);
        }
        return ans;
    }

    void checkRecipe(String rec ,List<List<String>> ingredients, HashSet<String> visited,Map<String,Boolean> canMake,Map<String,Integer> recipeToIndex){
        
        if(canMake.containsKey(rec) && canMake.get(rec))
            return;
        
        if(!recipeToIndex.containsKey(rec) || visited.contains(rec)){
            canMake.put(rec,false);
            return;
        }
        
        
        visited.add(rec);

        List<String> req = ingredients.get(recipeToIndex.get(rec));

        for(String r : req){
            checkRecipe(r,ingredients,visited,canMake,recipeToIndex);
            if(!canMake.get(r)){
                canMake.put(rec,false);
                return;
            }
        }
        canMake.put(rec,true);
    }
}