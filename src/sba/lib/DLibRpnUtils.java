/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sba.lib;

/**
 *
 * @author Sergio Flores
 */
public abstract class DLibRpnUtils {

    public static DLibRpnArgumentType getArgumentType(final String str) {
        DLibRpnArgumentType argumentType = DLibRpnArgumentType.UNDEFINED;

        if (str.compareTo(DLibRpnArgumentType.OPERAND.toString()) == 0) {
            argumentType = DLibRpnArgumentType.OPERAND;
        }
        else if (str.compareTo(DLibRpnArgumentType.OPERATOR.toString()) == 0) {
            argumentType = DLibRpnArgumentType.OPERATOR;
        }

        return argumentType;
    }

    public static DLibRpnOperator getOperator(final String str) {
        DLibRpnOperator operator = DLibRpnOperator.UNDEFINED;

        if (str.compareTo(DLibRpnOperator.ADDITION.toString()) == 0) {
            operator = DLibRpnOperator.ADDITION;
        }
        else if (str.compareTo(DLibRpnOperator.SUBTRACTION.toString()) == 0) {
            operator = DLibRpnOperator.SUBTRACTION;
        }
        else if (str.compareTo(DLibRpnOperator.MULTIPLICATION.toString()) == 0) {
            operator = DLibRpnOperator.MULTIPLICATION;
        }
        else if (str.compareTo(DLibRpnOperator.DIVISION.toString()) == 0) {
            operator = DLibRpnOperator.DIVISION;
        }

        return operator;
    }
}
