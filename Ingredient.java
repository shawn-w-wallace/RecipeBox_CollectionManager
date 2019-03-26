/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipebox;

import java.util.Scanner;

/**
 *
 * @author shawn
 */

public class Ingredient {
    
//variables
    
    //string to get characters entered by user
    String nameOfIngredient = "";
    //initialized empty string for unitMeasurement
    String unitMeasurement = "";
    //amount of ingredient e.g 2 and 1/2 cups = 2.5, double holds frational values
    double ingredientAmount = 0.0;
    //whole number,user will input number of calories per unit of measurement
    int numberCaloriesPerMeasurement = 0;
    //total caloies of ingredient calculated by ingredientAmount * numberCaloriesPerMeasurment.  double * int calculated as an integer value
    int totalCalories = 0;
    // upper limit allowable ingredientAmount, double to hold fractional values
    public final double MAX_INGREDIENT_AMOUNT = 100.00;
    //whole number upper limit on recommended daily calories
    public final int MAX_CALORIES = 2000;
    //whole number upper limit on calories per amount measured
    public final int MAX_NUMBER_CALORIES_PER_MEASUREMENT = 200;
    //used for exiting do-while loops for user entering various data
    boolean correct = false;

    /**
     * default constructor
     */
    public Ingredient() {
        this.nameOfIngredient = "";
        this.ingredientAmount = 0;
        this.numberCaloriesPerMeasurement = 0;
        this.totalCalories = 0;
        this.unitMeasurement = "";
    }

    /**
     * constructor taking parameters
     * @param nameOfIngredient the name of the ingredient
     * @param ingredientAmount the amount of the ingredient
     * @param numberCaloriesPerMeasurement number of calories per unit of measurement
     * @param totalCalories total number of calories
     * @param unitMeasurement what the ingredient is measured in i.e. cups, oz
     */
    public Ingredient(String nameOfIngredient, double ingredientAmount, 
            int numberCaloriesPerMeasurement, int totalCalories, String unitMeasurement) {

        this.nameOfIngredient = nameOfIngredient;
        this.ingredientAmount = ingredientAmount;
        this.numberCaloriesPerMeasurement = numberCaloriesPerMeasurement;
        this.totalCalories = totalCalories;
        this.unitMeasurement = unitMeasurement;
    }


    /**
     * @return nameOfIngredient name of the ingredient
     */
    public String getNameOfIngredient() {
        
        return nameOfIngredient;
    }

    /**
     * @param nameOfIngredient String value name of the ingredient
     * @return the name of the ingredient
     */
    public String setNameOfIngredient(String nameOfIngredient) {

        this.nameOfIngredient = nameOfIngredient;
        return nameOfIngredient;
    }

    /**
     * @return ingredientAmount the amount of the ingredient in the recipe
     */
    public double getIngredientAmount() {

        return ingredientAmount;
    }

    /**
     * @param ingredientAmount double value of the amount of the ingredient
     */
    public void setIngredientAmount(double ingredientAmount) {

        this.ingredientAmount = ingredientAmount;
    }

    /**
     * @return the numberCaloriesPerUnit calories per unit of measurement
     */
    public int getNumberCaloriesPerMeasurement() {

        return numberCaloriesPerMeasurement;
    }

    /**
     * @param numberCaloriesPerMeasurement the number of calories per unit of measurement
     */
    public void setNumberCaloriesPerMeasurement(int numberCaloriesPerMeasurement) {

        this.numberCaloriesPerMeasurement = numberCaloriesPerMeasurement;
    }

    /**
     * @return totalCalories Gets Total calories of the ingredient
     */
    public double getTotalCalories() {

        return totalCalories;
    }

    /**
     * @param totalCalories Total calories of the ingredient
     */
    public void setTotalCalories(int totalCalories) {

        this.totalCalories = totalCalories;
    }

    /**
     * @return unitMeasurement Gets the unit of measurement specified for the ingredient
     */
    public String getUnitMeasurement() {

        return unitMeasurement;
    }

    /**
     * @param unitMeasurement string value for setting what type of measurement the ingredient has
     */
    public void setUnitMeasurement(String unitMeasurement) {

        this.unitMeasurement = unitMeasurement;
    }

    /**
     * ingredient object
     * @return returns instance of newly created ingredient objects
     */
    public Ingredient createIngredient() {

        Scanner scnr = new Scanner(System.in);

        //takes user input as typed
        System.out.println("Please enter the name of the ingredient separated "
        + "by '_' if necessary:");
        nameOfIngredient =  scnr.next();
        
        //loop gets nameOfIngredient from user
        do {    
            //confirm input
            System.out.println("You entered " + nameOfIngredient + ". Is this "
            + "correct? (y or n)");
            String reply = scnr.next().toLowerCase();
                
            if (null == reply) {
                System.out.println ("Invalid input");
            }
            else                 
                switch (reply) {
                    // input incorrect, get correct input
                    case "n":
                        System.out.println ("Enter ingredient name: ");
                        nameOfIngredient = scnr.next();
                        break;
                    //nameOfIngredient is correct
                    case "y":
                        //call mutator to set nameOfIngredient
                        setNameOfIngredient(nameOfIngredient);
                        correct = true;
                        break;
                    //get input (y or n) again
                    default:
                        System.out.println ("Invalid input");
                        break;
                }
        } while (correct == false); 
        
        //reset bool
        correct = false;
        
        //gets unit of measurement for ingredient
        System.out.println ("Please enter the unit of measurement for "
        + nameOfIngredient + " (i.e. tsp, oz, cup(s), etc.):");
        unitMeasurement = scnr.next();
        
        do {        
            //confirm input
            System.out.println ("You entered " + unitMeasurement + " for the "
            + "unit of measurement. Is this correct? (y or n)");
            String reply = scnr.next().toLowerCase();
            
            if (null == reply) {
                System.out.println ("Invalid input");
            }
            else 
                switch (reply) {
                    //input incorrect, get correct input
                    case "n":
                        System.out.println ("Enter unit of measurement: ");
                        unitMeasurement = scnr.next();
                        break;
                    //unitMeasurement is correct
                    case "y":
                        //call mutator to set unitMeasurement
                        setUnitMeasurement(unitMeasurement);
                        correct = true;
                        break;
                    default:
                        //get input (y or n) again
                        System.out.println ("Invalid input");
                        break;
                }
        } while (correct == false);
        
        //reset bool
        correct = false;
        
        //gets the amount of the ingredient
        System.out.println("Please enter the number of " + unitMeasurement + " of "
        + nameOfIngredient + " we'll need in decimal format: ");
        
        if (scnr.hasNextFloat()) {
            ingredientAmount = scnr.nextFloat();
        
            while (ingredientAmount <= 0 || ingredientAmount > MAX_INGREDIENT_AMOUNT) {
                System.out.println("Please enter the number of " + unitMeasurement + " of "
                + nameOfIngredient + " we'll need in decimal format: ");
                ingredientAmount = scnr.nextFloat();
            }
            do {
                //confirm input
                System.out.println ("You entered " + ingredientAmount + " as the "
                + " number of " + unitMeasurement + " of " + nameOfIngredient 
                + " required. Is this correct? (y or n)");
                String reply = scnr.next().toLowerCase();
                
                if (null == reply) {
                    //program terminates
                    System.out.println ("Invalid input");
                    System.exit(0);//ends program because input is invalid type
                }
                else 
                    switch (reply) {
                      //input incorrect, get correct input
                        case "n":
                            System.out.println ("Enter the amount required: ");
                            ingredientAmount = scnr.nextFloat();
                            break;
                        //ingredientAmount correct
                        case "y":
                            //call mutator to set ingredientAmount
                            setIngredientAmount(ingredientAmount);
                            correct = true;
                            break;
                        default:
                            //get input (y or n) again
                            System.out.println ("Invalid input");
                            break;
                    }
            } while (correct == false);
        }
        else {
            //program terminates
            System.out.println("Error: That is not a number.");
            System.exit(0);
        }
      
        //reset bool
        correct = false;

        //gets number of calories in each unit of measurement of ingredient
        System.out.println("Please enter the number of calories per "
        + unitMeasurement + " as a positive whole number:");

        //input is an integer
        if (scnr.hasNextInt()) {
           numberCaloriesPerMeasurement = scnr.nextInt();
           
           //ensure input is in a valid integer range
            while (numberCaloriesPerMeasurement <= 0 || numberCaloriesPerMeasurement > MAX_NUMBER_CALORIES_PER_MEASUREMENT) {
                System.out.println("Please enter the number of calories per "
                + unitMeasurement + " as a positive whole number:");
                numberCaloriesPerMeasurement = scnr.nextInt();
            }
            
            do {
                //confirm input
                System.out.println ("You entered " + numberCaloriesPerMeasurement
                + " as the amount of calories per " + unitMeasurement + " of "
                + nameOfIngredient + ". Is this correct? (y or n)");
                String reply = scnr.next().toLowerCase();
                
                if (null == reply) {
                    //program terminates
                    System.out.println ("Invalid input");
                    System.exit(0); //ends program because input is invalid type
                }
                else 
                    switch (reply) {
                        //input incorrect, get correct input
                        case "n":
                            System.out.println ("Enter the amount of calories: ");
                            numberCaloriesPerMeasurement = scnr.nextInt();
                            break;
                        //numberCaloriesPerMeasurement is correct
                        case "y":
                            //call mutator to set numberCaloriesPerMeasurement
                            setNumberCaloriesPerMeasurement(numberCaloriesPerMeasurement);
                            correct = true;
                            break;
                        default:
                            //get input (y or n) again
                            System.out.println ("Invalid input");
                            break;
                    }
            } while (correct == false);
        }
        else {
            //program terminates
            System.out.println("Error: That is not a number.");
            System.exit(0);
        }
        
        //reset bool
        correct = false;

        /**
        * @param getIngredientAmount() getNumberCaloriesPerUnit()
        * call mutator to set totalCalories by accessors values of 
        * ingredientAmount multiplied by numberCaloriesPerMeasurement
        */

        setTotalCalories((int) (getIngredientAmount() * getNumberCaloriesPerMeasurement()));

        //print information using accessors
        System.out.println(getNameOfIngredient() + " uses " + getIngredientAmount()
        + " " + getUnitMeasurement() + " and has " + getTotalCalories() + " calories.");

        //Create instance of this object
        Ingredient newIngredient = new Ingredient(getNameOfIngredient(), getIngredientAmount(), getNumberCaloriesPerMeasurement(), (int) getTotalCalories(), getUnitMeasurement());

        //eeturn the object
        return newIngredient;
    }
}
