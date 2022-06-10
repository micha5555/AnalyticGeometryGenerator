package pl.edu.pw.ee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import pl.edu.pw.ee.exceptions.CannotPassException;
import pl.edu.pw.ee.services.Element;

public class Node {
    private int idOfNode;
    private int[] nextNodesIDs;
    private Class<?>[][] needed;
    private Class<?> whatNodeGives; //Jaką daną daje Node do puli

    public Node(int id, int[] nextNodesIDs , Class<?>[][] needed, Class<?> whatGives){
        idOfNode = id;
        this.nextNodesIDs = nextNodesIDs;
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

    // public static Node[] createNodes(){
    //     Node[] nodes = new Node[13];
    //     nodes[0] = new Node(0, new int[]{5, 7, 8}, new Class<?>[]{}, whatGives);
    //     nodes[1] = new Node(1, new int[]{6, 7}, new Class<?>[]{}, whatGives);
    //     nodes[2] = new Node(2, new int[]{5, 6, 8, 9}, new Class<?>[]{}, whatGives);
    //     nodes[3] = new Node(3, new int[]{5, 7, 9}, new Class<?>[]{}, whatGives);
    //     nodes[4] = new Node(4, new int[]{7, 8, 9}, new Class<?>[]{}, whatGives);
    //     nodes[5] = new Node(5, new int[]{}, new Class<?>[]{{Point.class}}, whatGives);
    //     nodes[6] = new Node(6, new int[]{}, needed, whatGives);
    //     nodes[7] = new Node(7, new int[]{11, 12}, needed, whatGives);
    //     nodes[8] = new Node(8, new int[]{10, 12}, needed, whatGives);
    //     nodes[9] = new Node(9, new int[]{10, 11}, needed, whatGives);
    //     nodes[10] = new Node(10, new int[]{}, needed, whatGives);
    //     nodes[11] = new Node(11, new int[]{}, needed, whatGives);
    //     nodes[12] = new Node(12, new int[]{}, needed, whatGives);
        
    // }
}
