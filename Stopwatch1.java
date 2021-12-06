import java.math.BigInteger;

class Stopwatch1 {
    private final long nanoSecondsPerMillisecond = 1000000;
    private final long nanoSecondsPerSecond = 1000000000;
    private final long nanoSecondsPerMinute = 60000000000L;
    private final long nanoSecondsPerHour = 3600000000000L;

    private long stopWatchStartTime = 0;
    private long stopWatchStopTime = 0;
    private boolean stopWatchRunning = false;


    public void start() {
        this.stopWatchStartTime = System.nanoTime();
        this.stopWatchRunning = true;
    }


    public void stop() {
        this.stopWatchStopTime = System.nanoTime();
        this.stopWatchRunning = false;
    }


    public long getElapsedMilliseconds() {
        long elapsedTime;

        if (stopWatchRunning)
            elapsedTime = (System.nanoTime() - stopWatchStartTime);
        else
            elapsedTime = (stopWatchStopTime - stopWatchStartTime);

        return elapsedTime / nanoSecondsPerMillisecond;
    }


    public long getElapsedSeconds() {
        long elapsedTime;

        if (stopWatchRunning)
            elapsedTime = (System.nanoTime() - stopWatchStartTime);
        else
            elapsedTime = (stopWatchStopTime - stopWatchStartTime);

        return elapsedTime / nanoSecondsPerSecond;
    }


    public long getElapsedMinutes() {
        long elapsedTime;
        if (stopWatchRunning)
            elapsedTime = (System.nanoTime() - stopWatchStartTime);
        else
            elapsedTime = (stopWatchStopTime - stopWatchStartTime);

        return elapsedTime / nanoSecondsPerMinute;
    }


    public long getElapsedHours() {
        long elapsedTime;
        if (stopWatchRunning)
            elapsedTime = (System.nanoTime() - stopWatchStartTime);
        else
            elapsedTime = (stopWatchStopTime - stopWatchStartTime);

        return elapsedTime / nanoSecondsPerHour;
    }


}