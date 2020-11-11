package com.whu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hongchao Yang
 * @date 2020-11-06 18:47
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Code {
    //代码类型
    String codeType;
    //类名(主要针对java)
    String className;
    //具体代码
    String code;
}
