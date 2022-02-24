package com.xiayu.bi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 *
 * @author quanhaoxing
 * @date 2021年05月10日
 */

@Data
@AllArgsConstructor
@ToString
public class FunctionContentAsBo {

    String asOfHeader;

    String asOfLast;

    String functionName;

    List<String> values;

    String content;

}
