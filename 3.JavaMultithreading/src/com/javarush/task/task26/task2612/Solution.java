package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();
    private boolean busy;

    public void someMethod() {
        // Implement the logic here. Use the lock field
        lock.tryLock();
        try{
            actionIfLockIsBusy();
        }finally {
            if(lock.tryLock()) {
                lock.unlock();
            }
            actionIfLockIsFree();
        }
    }

    public void actionIfLockIsFree() {
        busy = false;
    }

    public void actionIfLockIsBusy() {
        busy = true;
    }
}
