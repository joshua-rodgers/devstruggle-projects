package com.joshuarodgers.devstruggle.basicanimation;

// 03/13/2019
// -
// This is an exercise in simplifying and modeling problems. The ultimate goal is a graphical, 'block' styled
// two-dimensional gaming environment. My goal in this little demonstration is to sketch out the absolute simplest 
// sort of game loop imaginable. It will consist of a timing mechanism encapsulated in a class that will print a
// message to the console each second. The idea is that each message represents what would in a game environment 
// amount to a rendering operation.

public class Counter {
    private long startTime;
    private long currentTime;
    private long elapsedTime;

    protected void runCounter() {
        startTime = System.currentTimeMillis();  // initialize startTime for the first iteration
        while(true) {
            currentTime = System.currentTimeMillis();
            elapsedTime += currentTime - startTime;
            startTime = currentTime;   // currentTime from last iteration becomes startTime of the next
            if(elapsedTime >= 1000) {
                Switch.flip();
                elapsedTime = 0;
            }
        }
    }

    public static void main(String[] args) {
        new Counter().runCounter();
    }
}

// Basically a light switch, it's in the 'off' position to start as a result of default initialization. The
// method just makes it the opposite each time it's called. The method and state flag are static to allow 
// calling the method without an instance.
class Switch {
    private static boolean state;

    public static void flip(){
        if(state) {
            state = !state;
            System.out.println("off");
        } else {
            state = !state;
            System.out.println("on");
        }
    }
}
