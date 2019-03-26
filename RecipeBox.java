/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipebox;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author shawn
 */
public class RecipeBox {

    /**
     * instance of arraylist
     */
        public ArrayList<Recipe> listOfRecipes = new ArrayList<>();

        /**
         * @return arrayList of recipes
         */
        public ArrayList<Recipe> getListOfRecipes() {
            return listOfRecipes;
        }

        /**
         * @param listOfRecipes is the list of recipes
         */
        public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
            this.listOfRecipes = listOfRecipes;
        }

    /**
     * default constructor
     */
        public RecipeBox() {
            this.listOfRecipes = new ArrayList<>();
        }

    /**
     * constructor taking parameters
     * @param listOfRecipes array list of recipes 
     */
        public RecipeBox(ArrayList<Recipe> listOfRecipes) {
            this.listOfRecipes = listOfRecipes;
        }

        /**
         * @param selectedRecipe the selected recipe to print
         */
        public void printAllRecipeDetails(Recipe selectedRecipe) {

            //grabs and print all recipe objects
            for (Recipe recipe : listOfRecipes) {
                
                if (recipe.equals(selectedRecipe)) {
                    recipe.printRecipe();
                    return;
                }
            }
        }

    /**
     * prints only the recipe names in the arraylist
     */
        public void printAllRecipeNames() {
            //loop through the ArrayList and print the recipe name of each
            for (int i = 0; i < listOfRecipes.size(); i++) {
            //numbers each recipe in list
                int listNumber = i + 1;
                System.out.println("" + listNumber + ". " + listOfRecipes.get(i).getRecipeName());
            }
        }

    /**
     * add new recipe to Array List
     */
        public void addNewRecipe() {
            Recipe newRecipe = new Recipe();
            listOfRecipes.add(newRecipe.createNewRecipe());
        }

        /**
         * @param selectedRecipe recipe object to be removed
         * 
         */
        public void removeRecipe(Recipe selectedRecipe) {
            //int value to delete recipe at index based on user input
            int delete = 0;
            //iterate through arraylist
            for (Recipe recipe : listOfRecipes) {
                //look for match corresponding with input and index
                if (recipe.equals(selectedRecipe)) {
                    //match found, get the index of the recipe and set to delete
                    delete = listOfRecipes.indexOf(selectedRecipe);
                }
            }
            //deletes recipe
            listOfRecipes.remove(delete);
        }
}