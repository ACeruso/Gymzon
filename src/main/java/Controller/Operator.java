package Controller;

public enum Operator {
    GT, LT, EQ, NE, GE, LE, MATCH;

    @Override
    public String toString(){
        return switch(this){
            case GT ->" > ";
            case LT -> " < ";
            case EQ -> " = ";
            case NE -> " != ";
            case GE -> " >= ";
            case LE -> " <= ";
            case MATCH -> " LIKE ";

        };
    }
}
