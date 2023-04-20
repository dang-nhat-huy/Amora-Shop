/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cart;

/**
 *
 * @author long
 */
import java.io.Serializable;

public class CartError implements Serializable {
    private String invalidQuantityErr;
    private String exceedHoldingQuantityErr;

    public String getInvalidQuantityErr() {
        return invalidQuantityErr;
    }

    public void setInvalidQuantityErr(String invalidQuantityErr) {
        this.invalidQuantityErr = invalidQuantityErr;
    }

    public String getExceedHoldingQuantityErr() {
        return exceedHoldingQuantityErr;
    }

    public void setExceedHoldingQuantityErr(String exceedHoldingQuantityErr) {
        this.exceedHoldingQuantityErr = exceedHoldingQuantityErr;
    }
}
