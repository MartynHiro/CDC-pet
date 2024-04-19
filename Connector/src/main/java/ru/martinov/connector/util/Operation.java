package ru.martinov.connector.util;

public enum Operation {
    READ("r"),
    CREATE("c"),
    UPDATE("u"),
    DELETE("d");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public String code() {
        return this.code;
    }

    public static Operation forCode(String code) {
        Operation[] operations = values();

        for (Operation op : operations) {
            if (op.code().equalsIgnoreCase(code)) {
                return op;
            }
        }
        return null;
    }
}
