package pl.edu.pw.ee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import pl.edu.pw.ee.exceptions.CannotPassException;
import pl.edu.pw.ee.services.Element;

public class Node {
    private int idOfNode;
    private int[] nextNodesIDs;
    private int[] possibleExercises;
    private Class<?>[][] needed;
    private Class<?> whatNodeGives; //Jaką daną daje Node do puli

    public Node(int id, int[] nextNodesIDs, int[] possibleExercises, Class<?>[][] needed, Class<?> whatGives){
        idOfNode = id;
        this.nextNodesIDs = nextNodesIDs;
        this.possibleExercises = possibleExercises;
        this.needed = needed;
        this.whatNodeGives = whatGives;
    }

    //Define whether can pass into this Node
    public boolean canPass(ArrayList<Element> list) throws CannotPassException{
        if(list.size() == 0 && needed.length == 0){
            return true;
        }
        if(list.size() != needed.length){
            throw new CannotPassException("Cannot pass to this Node");
        }
        boolean found = false;
        //TODO: przerobic, bo teraz działa dla pojedyńczego zestawu wymagań
        for(int i = 0; i < needed.length; i++){
            for(int j = 0; j < list.size(); j++){
                if(list.get(j).getClass().equals(needed[i])){
                    found = true;
                }
            }
            if(!found){
                throw new CannotPassException("Cannot pass to this Node");
            }
            found = false;
        }
        return true;
    }

    public Element getElement() throws Exception{
        Constructor cons = whatNodeGives.getConstructor();
        return  (Element)cons.newInstance();
    }

    //Giving exercises that can be made from this node
    public int[] getIDsOfPossibleExercises(){
        int[] indexesOfPossibleExercises = new int[possibleExercises.length];
        for(int i = 0; i < possibleExercises.length; i++){
            indexesOfPossibleExercises[i] = possibleExercises[i] - 1;
        }
        return indexesOfPossibleExercises;
    }

    public int[] getNextNodesIDs(){
        return nextNodesIDs;
    }
    
    public int getID(){
        return idOfNode;
    }

    public static Node[] createNodes(){
        Node[] nodes = new Node[13];
        nodes[0] = new Node(0, new int[]{5, 7, 8}, new int[]{}, new Class<?>[][]{}, Point.class);
        nodes[1] = new Node(1, new int[]{6, 7}, new int[]{10, 14},new Class<?>[][]{}, Line.class);
        nodes[2] = new Node(2, new int[]{5, 6, 8, 9}, new int[]{5, 6, 11, 12},new Class<?>[][]{}, Triangle.class);
        nodes[3] = new Node(3, new int[]{5, 7, 9}, new int[]{7, 8, 9, 13},new Class<?>[][]{}, Square.class);
        nodes[4] = new Node(4, new int[]{7, 8, 9}, new int[]{},new Class<?>[][]{}, Circle.class);
        nodes[5] = new Node(5, new int[]{}, new int[]{1, 16, 17},new Class<?>[][]{{Point.class},{Triangle.class},{Square.class}}, Point.class);
        nodes[6] = new Node(6, new int[]{}, new int[]{2, 3, 4, 20},new Class<?>[][]{{Line.class},{Triangle.class}}, Line.class);
        nodes[7] = new Node(7, new int[]{11, 12}, new int[]{20, 21},new Class<?>[][]{{Point.class},{Line.class},{Square.class},{Circle.class}}, Triangle.class);
        nodes[8] = new Node(8, new int[]{10, 12}, new int[]{16, 21},new Class<?>[][]{{Point.class},{Triangle.class},{Circle.class}}, Square.class);
        nodes[9] = new Node(9, new int[]{10, 11}, new int[]{15},new Class<?>[][]{{Triangle.class},{Square.class},{Circle.class}}, Circle.class);
        nodes[10] = new Node(10, new int[]{}, new int[]{18, 19},new Class<?>[][]{{Square.class, Circle.class}}, Triangle.class);
        nodes[11] = new Node(11, new int[]{}, new int[]{18, 19},new Class<?>[][]{{Triangle.class, Circle.class}}, Square.class);
        nodes[12] = new Node(12, new int[]{}, new int[]{18, 19},new Class<?>[][]{{Triangle.class, Square.class}}, Circle.class);
        
        return nodes;
    }
}
