package jill.payment.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jill
 * @since 2020-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String proId;

    private String proName;

    private String userId;

    private Integer proDelete;


}
