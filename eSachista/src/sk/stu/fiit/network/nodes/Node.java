package sk.stu.fiit.network.nodes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Martin Melisek
 */
public abstract class Node implements Runnable{

    protected ExecutorService executor = Executors.newCachedThreadPool();

}
