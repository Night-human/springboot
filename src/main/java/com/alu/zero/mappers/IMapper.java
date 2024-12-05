package com.alu.zero.mappers;

import java.util.List;

public interface IMapper<IN, OUT> {
    OUT map(IN in);
    List<OUT> map(List<IN> in);
}
