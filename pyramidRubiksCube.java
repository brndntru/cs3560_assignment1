import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class pyramidRubiksCube {
    private static final int numFaces = 4; // pyramid rubik's cube has 4 faces (sides)
    private static final int faceSize = 9; // each face has 9 tiles
    private static final String[] colors = {"Red", "Green", "Blue", "Yellow"}; // array of colors

    private Map<String, char[]> faces; // declares hashmap that stores each face with 9-tile color array
    private Map<String, String[]> edges; // declares hashmap that stores adjacent face relationships

    public pyramidRubiksCube() {
        faces = new HashMap<>(); // initialize faces map
        edges = new HashMap<>(); // initialize edges map
        initializeFaces(); // calls method to initialize faces with colors
        initializeEdges(); // calls method to initialize edges with adjacent face names
    }

    // method to initialize faces with 9 tiles of corresponding color
    private void initializeFaces() {
        faces.put("front", faceArray('R'));
        faces.put("left", faceArray('G'));
        faces.put("right", faceArray('B'));
        faces.put("bottom", faceArray('Y'));
    }

    // method to create faces filled with 9 tiles of same color
    private char[] faceArray(char color) {
        char[] face = new char[faceSize]; // creates array for 9 face tiles
        Arrays.fill(face, color); // fills face tiles with same, given color
        return face;
    }

    // method to initialize edges with adjacent faces
    private void initializeEdges() {
        edges.put("front", new String[] {"left", "right", "bottom"});
        edges.put("left", new String[] {"front", "right", "bottom"});
        edges.put("right", new String[] {"front", "left", "bottom"});
        edges.put("bottom", new String[] {"front", "left", "right"});
    }

    // method to validate cube; check if each face contains 9 tiles and all the same color
    public boolean validateCube() {
        for (Map.Entry<String, char[]> entry : faces.entrySet()) {
            char[] face = entry.getValue(); // gets the face's tiles
            if (face.length != faceSize) { // checks if face has 9 tiles
                return false;
            }
            char color = face[0]; // sets first tile's color
            for (char tile : face) {
                if (tile != color) { // checks if all tiles match the face color
                    return false;
                }
            }
        }
        return true; // cube is valid, returning true, if all conditions are met
    }

    // method to print cube's faces
    public void printCube() {
        for (Map.Entry<String, char[]> entry : faces.entrySet()) {
            System.out.println(entry.getKey() + " face: " + Arrays.toString(entry.getValue()));
        }
    }
}
