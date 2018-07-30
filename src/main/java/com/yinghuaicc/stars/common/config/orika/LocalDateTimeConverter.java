package com.yinghuaicc.stars.common.config.orika;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/5/28 下午5:00
 * @Description: LocalDate转换器，解决使用Orika的MapperFactory转换LocalDateTime出现的no constructors found for LocalDateTime问题
 * @Modified:
 */
public class LocalDateTimeConverter extends BidirectionalConverter<LocalDateTime,LocalDateTime> {

    @Override
    public LocalDateTime convertTo(LocalDateTime source, Type<LocalDateTime> destinationType, MappingContext mappingContext) {
        return source;
    }

    @Override
    public LocalDateTime convertFrom(LocalDateTime source, Type<LocalDateTime> destinationType, MappingContext mappingContext) {
        return source;
    }
}
