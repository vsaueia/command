package br.com.vs.nullobject;

import java.time.LocalDateTime;

public abstract class Employee {
    public abstract boolean isTimeToPay(LocalDateTime time);

    public abstract void pay();

    public static final Employee NULL = new NullEmployee();

    private final static class NullEmployee extends Employee {
        @Override
        public boolean isTimeToPay(LocalDateTime time) {
            return false;
        }

        @Override
        public void pay() {
        }
    }

}
