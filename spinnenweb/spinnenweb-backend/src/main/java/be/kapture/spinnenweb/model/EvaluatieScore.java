package be.kapture.spinnenweb.model;

import be.kapture.spinnenweb.exception.EnumerationElementParserException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public enum EvaluatieScore {
    GEEN_EVALUATIE,
    LEVEL_0,
    LEVEL_1,
    LEVEL_2,
    LEVEL_3,
    LEVEL_4,
    LEVEL_5;

    public static EvaluatieScore fromScoreString(String stringCellValue) {
        if (stringCellValue.equals("0"))
            return LEVEL_0;
        else if (stringCellValue.equals("1"))
            return LEVEL_1;
        else if (stringCellValue.equals("2"))
            return LEVEL_2;
        else if (stringCellValue.equals("3"))
            return LEVEL_3;
        else if (stringCellValue.equals("4"))
            return LEVEL_4;
        else if (stringCellValue.equals("5"))
            return LEVEL_5;
        else if (stringCellValue.isEmpty())
            return GEEN_EVALUATIE;
        else
            throw new EnumerationElementParserException(stringCellValue);
    }

    public Integer toIntegerValue() {
        switch (this) {
            case GEEN_EVALUATIE: return -1;
            case LEVEL_0: return 0;
            case LEVEL_1: return 1;
            case LEVEL_2: return 2;
            case LEVEL_3: return 3;
            case LEVEL_4: return 4;
            case LEVEL_5: return 5;
        }

        throw new NotImplementedException();
    }

    public boolean isEvaluated() {
        return this != GEEN_EVALUATIE;
    }
}
