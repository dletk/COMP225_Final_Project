package MazeGenerator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by DucLe on 11/25/16.
 */
public class testMazeSolving_BFS {
    private Grid aMaze = new Grid(20, 20, 50, 50);
    private MazeSolving_BFS solver;

    @Test
    public void testConstructor() {
        assertNotNull(new MazeSolving_BFS(aMaze.getArrCells(), aMaze.getArrWalls_ver(), aMaze.getArrWalls_hor(), 20));
    }

    @Test
    public void testFindNeighbors() {
        aMaze.generateMaze();
        solver = new MazeSolving_BFS(aMaze.getArrCells(), aMaze.getArrWalls_ver(), aMaze.getArrWalls_hor(), 20);
//        To run this test, comment out the timing pause(50) in generateMaze first
        assertNotEquals(new ArrayList<Cell>(), solver.findNeighbors(aMaze.getArrCells()[19][19]));
        System.out.println(solver.findNeighbors(aMaze.getArrCells()[19][19]));
    }

    @Test
    public void testDictParent() {
        aMaze.generateMaze();
        solver = new MazeSolving_BFS(aMaze.getArrCells(), aMaze.getArrWalls_ver(), aMaze.getArrWalls_hor(), 20);
        solver.solve_BFS();
        assertNotEquals("dictParents empty", new HashMap<Cell, Cell>(), solver.getDictParents());
        System.out.println(solver.getDictParents());
    }
}
