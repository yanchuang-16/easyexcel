package com.alibaba.excel.converters.biginteger;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.util.NumberUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;

/**
 * @description:
 * @author: YanChuang
 * @time: 2019/12/9 21:16
 */
public class BigIntegerStringConverter implements Converter<BigInteger> {
    @Override
    public Class supportJavaTypeKey() {
        return BigInteger.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public BigInteger convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
                                        GlobalConfiguration globalConfiguration) throws ParseException {
        return BigInteger.valueOf(NumberUtils.parseBigDecimal(cellData.getStringValue(), contentProperty).longValue());
    }

    @Override
    public CellData convertToExcelData(BigInteger value, ExcelContentProperty contentProperty,
                                       GlobalConfiguration globalConfiguration) {
        return NumberUtils.formatToCellData(new BigDecimal(value), contentProperty);
    }
}
