package enums;

public enum Level {

    GOLD(3, null), SILVER(2, Level.GOLD), BASIC(1, Level.SILVER);

    private final int value;
    private final Level next;

    public int intValue() {
        return this.value;
    }

    Level(int value, Level next) {
        this.value = value;
        this.next = next;
    }

    public Level nextLevel() {
        return this.next;
    }

    public static Level valueOf(int value) {
        switch (value) {
            case 1: return BASIC;
            case 2: return SILVER;
            case 3: return GOLD;
            default:
                throw new AssertionError("알 수 없는 값입니다:" + value);
        }
    }

}
