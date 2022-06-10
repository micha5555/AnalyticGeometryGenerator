package pl.edu.pw.ee;

import java.util.ArrayList;
import java.util.Random;

import pl.edu.pw.ee.exceptions.CannotPassException;
import pl.edu.pw.ee.exceptions.IllegalElementsForThisExerciseException;
import pl.edu.pw.ee.exercises.*;
import pl.edu.pw.ee.services.Element;
import pl.edu.pw.ee.services.Exercise;

public class Generator {
    private Exercise[] exercises = new Exercise[21];
    Node[] nodes;

    public Generator(){
        nodes = Node.createNodes();
        exercises[0] = new Ex1();
        exercises[1] = new Ex2();
        exercises[2] = new Ex3();
        exercises[3] = new Ex4();
        exercises[4] = new Ex5();
        exercises[5] = new Ex6();
        exercises[6] = new Ex7();
        exercises[7] = new Ex8();
        exercises[8] = new Ex9();
        exercises[9] = new Ex10();
        exercises[10] = new Ex11();
        exercises[11] = new Ex12();
        exercises[12] = new Ex13();
        exercises[13] = new Ex14();
        exercises[14] = new Ex15();
        exercises[15] = new Ex16();
        exercises[16] = new Ex17();
        exercises[17] = new Ex18();
        exercises[18] = new Ex19();
        exercises[19] = new Ex20();
        exercises[20] = new Ex21();
    }

    //Przechwytywanie wyjątku wyżej
    public Exercise generateExercise() throws CannotPassException{
        Random rand = new Random();
        ArrayList<Element> elements = new ArrayList<>();
        ArrayList<Exercise> realPossibleExercises;
        ArrayList<Node> realPossibleNodes;
        Node actual = getFirstNode(nodes, rand);
        try {
            elements.add(actual.getElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
        while(true){
            int[] possibleExercises = actual.getIDsOfPossibleExercises();
            int[] possibleNextNodes = actual.getNextNodesIDs();
            realPossibleExercises = getRealPossibleExercises(elements, possibleExercises);
            realPossibleNodes = getRealPossibleNodes(elements, possibleNextNodes);
            int id = rand.nextInt(realPossibleExercises.size() + realPossibleNodes.size());
            if(id < realPossibleExercises.size()){
                return realPossibleExercises.get(id);
            }
            actual = realPossibleNodes.get(id - realPossibleExercises.size());
            try {
                elements.add(actual.getElement());
            } catch (Exception e) {
                ;
            }
        }
    }

    private Node getFirstNode(Node[] nodes, Random r){
        ArrayList<Node> possiblyNextNodes = new ArrayList<>();
        for(int i = 0; i < nodes.length; i++){
            try {
                if(nodes[i].canPass(new ArrayList<Element>())){
                    possiblyNextNodes.add(nodes[i]);
                }
            } catch (CannotPassException e) {
                ;
            }
        }
        return nodes[r.nextInt(possiblyNextNodes.size())];
    }

    private ArrayList<Node> getRealPossibleNodes(ArrayList<Element> elements, int[] possibleNextNodes){
        ArrayList<Node> realPossibleNodes = new ArrayList<>();
        for(int i = 0; i < possibleNextNodes.length; i++){
            try {
                if(nodes[possibleNextNodes[i]].canPass(elements)){
                    realPossibleNodes.add(nodes[possibleNextNodes[i]]);
                }
            } catch (CannotPassException e) {
                ;
            }
        }
        return realPossibleNodes;
    }

    private ArrayList<Exercise> getRealPossibleExercises(ArrayList<Element> elements, int[] possibleExercises){
        ArrayList<Exercise> realPossibleExercises = new ArrayList<>();
        for(int i = 0; i < possibleExercises.length; i++){
            try{
                exercises[possibleExercises[i]].insertElements(elements);
                realPossibleExercises.add(exercises[possibleExercises[i]]);
            }catch(IllegalElementsForThisExerciseException e){
                ;
            }
        }
        return realPossibleExercises;
    }
}
