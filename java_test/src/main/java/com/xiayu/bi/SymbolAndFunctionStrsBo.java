package com.xiayu.bi;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author quanhaoxing
 * @create 2021-05-10
 */
@Data
@AllArgsConstructor
public class SymbolAndFunctionStrsBo {

    String symbol;

    List<String> functionStrs;

    String idsName;

}
