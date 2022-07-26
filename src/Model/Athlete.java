package Model;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

/****************************************************************************
 * Represents an athlete
 *
 * @author Pol Navarro Solà
 * @author Óscar Cubeles Ollé
 *
 * @since 2020-11-26
 *
 * @see Comparable
 *
 ****************************************************************************/
public class Athlete implements Comparable <Athlete>{

    /**
     * Model.Athlete's name
     */
    private String name;
    /**
     * Model.Athlete's surname
     */
    @SerializedName(value="lastname")
    private String surname;
    /**
     * Model.Athlete's age
     */
    private int age;
    /**
     * Model.Athlete's average distance performed
     */
    private float distance;
    /**
     * Model.Athlete's average time spent per distance
     */
    private float time;
    /**
     * Model.Athlete's type: (Sprinter, Trail Runner or Long Distance Runner)
     */
    private String type;
    /**
     * Model.Athlete's country name
     */
    @SerializedName(value="nation")
    private String country;
    /**
     * Model.Athlete's priority value
     */
    private float priority;

    /****************************************************************************
     *
     * Create a new athlete from given parameters
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     *
     * @param name The name of the new athlete
     * @param surname The surname of the new athlete
     * @param age The age of the new athlete
     * @param distance The distance it moves the new athlete
     * @param time The time it spends the new athlete
     * @param type The name of the athletes type
     *
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    public void createAthlete(String name, String surname, int age, float distance, float time, String type){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.distance = distance;
        this.time = time;
        this.type = type;
        this.priority = distance/time;
    }

    /****************************************************************************
     *
     * Given an athlete, a priority is calculated for each of them, to calculate it,
     * we take into account the <b>average</b> distance over the <b>average</b> time
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    public void calculatePriority(){
        this.priority = distance/time;
    }

    /****************************************************************************
     *
     * Gets the priority that we have previously calculated
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     *
     * @return A number representing the priority of the athlete
     *
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    public float getPriority() {
        return priority;
    }


    /****************************************************************************
     *
     * Gets the athlete's age
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     *
     * @return The age of the athlete
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    public int getAge() {
        return age;
    }

    /****************************************************************************
     *
     * Get the total distance the runner does without taking into account the time
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     *
     * @return The distance the runner runs in total
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    public float getDistance() {
        return distance;
    }

    /****************************************************************************
     *
     * Gets the type of runner the athlete is
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     *
     * @return A string with the type of runner it is
     *
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    public String getType() {
        return type;
    }

    /****************************************************************************
     *
     * Gets the athlete's country name
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     *
     * @return The country name where the athlete has born
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    public String getCountry() {
        return country;
    }

    /****************************************************************************
     *
     * Get the name and surname as a unique variable
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     *
     * @return The athlete's name appended to its surname
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    public String getFullname(){
        return (this.name+" "+ this.surname);
    }

    /****************************************************************************
     *
     * Compare a given athlete with a different one, using their priority
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     *
     * @param o An athlete you want to compare
     *
     * @return A int that show if is less (-1), equal (0) or more (1)
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    @Override
    public int compareTo(@NotNull Athlete o) {
        if(country.compareTo(o.country) != 0){
            return country.compareTo(o.country);
        }
        else{
            return  getFullname().compareTo(o.getFullname());
        }
    }

    /****************************************************************************
     *
     * Checks if the athlete type is among Sprinter, Trail Runner or Long distance Runner
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * @param type Athlete type to be compared
     *
     * @return The athlete's name appended to its surname
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    public static boolean isValidAthlete(String type){
        return type.equals("Sprinter") || type.equals("Trail Runner") || type.equals("Long distance Runner,");
    }
}