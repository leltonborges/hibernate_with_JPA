package org.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import java.util.Date;

@Getter
@AllArgsConstructor
@ToString
public class SoldReportVO {
    private String nameProduct;
    private Long quantitySales;
    private Date dataLastSales;
}
