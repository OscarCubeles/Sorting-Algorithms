package Model;

/****************************************************************************
 * Represents a club
 *
 * @author Pol Navarro Solà
 * @author Óscar Cubeles Ollé
 *
 * @since 2020-11-26
 *
 ****************************************************************************/
public class Club implements Comparable<Club> {
    /**
     * Model.Club's name
     */
    private String name;
    /**
     * Model.Club's country place
     */
    private String nation;
    /**
     * Model.Club's founding year
     */
    private int date;
    /**
     * Model.Club's total athletes
     */
    private Athlete[] at;
    /**
     * Model.Club's average age
     */
    private float average_age = 0;

    /****************************************************************************
     *
     * Calculating the average age of the club by accessing each member
     * age
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    public void calculateAverageAge() {
        int i = 0;
        for(; i < getAtAsArray().length; i++){
            average_age += getAt(i).getAge();
        }

        average_age /= i;
    }

    /****************************************************************************
     *
     * Get all the information of a athlete from a club in the class,
     * using a value to select which position in the set is selected
     *
     * @param position The position in the array you want to select
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * @return The athlete in that position
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    public Athlete getAt(int position) {
        return at[position];
    }

    /****************************************************************************
     *
     * Get the athlete array as a full array in the class
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * @return The athlete array
     *
     * @since 2020-11-2020
     *
     ****************************************************************************/
    public Athlete[] getAtAsArray(){
        return at;
    }

    /****************************************************************************
     *
     * Get the average age of club in the class
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * @return The average age of the club
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    public float getAverage_age() {
        return average_age;
    }

    /****************************************************************************
     *
     * Get the name of club in the class
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * @return The name of the club
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    public String getName() {
        return name;
    }

    /****************************************************************************
     *
     * Setter to set the name of club in the class
     *
     * @param name A string with the new name
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * @since 2020-11-26
     *
     *
     ****************************************************************************/
    public void setName(String name) {
        this.name = name;
    }

    /****************************************************************************
     *
     * Get the country where the club is situated
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * @return The country name of the club
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    public String getNation() {
        return nation;
    }

    /****************************************************************************
     *
     * Setter to set a group of athletes in the class
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * @param at A set of athletes grouped in an array
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    public void setAt(Athlete[] at) {
        this.at = at;
    }

    /****************************************************************************
     *
     * Compare to a club average age to know if is older or younger
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     * @param club A club object with their attributes
     *
     * @return A int that show if is less (-1), equal (0) or more (1)
     *
     * @since 2020-11-26
     *
     ****************************************************************************/
    @Override
    public int compareTo(Club club) {
        float compareAge = ((Club)club).getAverage_age();
        float difference = (this.average_age - compareAge);

        return (int)(difference/Math.abs(difference));
    }
}
