package DataAccess;

import Model.Club;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;

/****************************************************************************
 * Reads a file and return it as a variable
 *
 * @author Pol Navarro Solà
 * @author Óscar Cubeles Ollé
 *
 * @since 2020-11-26
 *
 ****************************************************************************/
public class DataAccess {

    /****************************************************************************
     *
     * Read the json file given the path
     *
     * @author Pol Navarro Solà
     * @author Óscar Cubeles Ollé
     *
     *
     * @param dataset The name of the file that wants to be read
     *
     * @return A set of clubs with all the athletes inside
     *
     * @throws FileNotFoundException The file does not exist
     *
     * @since 2020-11-26
     *
     * @see FileNotFoundException
     *
     ****************************************************************************/
    public Club[] readDataset(String dataset) throws FileNotFoundException {
        Gson gson = new Gson();
        Club[] clubs;
        String filename = ("resources/dataset" + dataset + ".json");
        Reader reader = new FileReader(filename);

        clubs = gson.fromJson(reader, (Type) Club[].class);

        for (Club club : clubs) {
            club.calculateAverageAge();
            for (int j = 0; j < club.getAtAsArray().length; j++) {
                club.getAt(j).calculatePriority();
            }
        }
        return clubs;
    }

}
