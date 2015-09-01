/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib;

/**
 *
 * @author Sergio Flores
 */
public final class DLibRpnArgument {

    private Object moArgument;
    private DLibRpnArgumentType meArgumentType;

    /**
     * @param argument DLibRpnOperator (+, -, *, /) or operand name as String.
     * @param argumentType DLibRpnArgumentType (OPERAND or OPERATOR).
     */
    public DLibRpnArgument(Object argument, DLibRpnArgumentType argumentType) {
        if (argument instanceof DLibRpnOperator || argument instanceof String) {
            moArgument = argument;
            meArgumentType = argumentType;
        }
        else {
            moArgument = null;
            meArgumentType = DLibRpnArgumentType.UNDEFINED;
        }

    }

    public Object getArgument() {
        return moArgument;
    }

    public DLibRpnArgumentType getArgumentType() {
        return meArgumentType;
    }
}
