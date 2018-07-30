package com.yinghuaicc.stars.service.cqrs.standard;

import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardExportDTO;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 你看见过我吗？你想一想在回答。 on 2018/7/29.
 */
public interface StandardExportService {

    void getStandardExportList(HttpServletResponse response, StandardExportDTO standardExportDTO) throws Exception;
    void getStandardExportList1(HttpServletResponse response, StandardExportDTO standardExportDTO) throws Exception;
    void getStandardyzlExportList(HttpServletResponse response, StandardExportDTO standardExportDTO) throws Exception;
    void getFittedExportList(HttpServletResponse response, StandardExportDTO standardExportDTO) throws Exception;
    void getFittedExportList1(HttpServletResponse response, StandardExportDTO standardExportDTO) throws Exception;
    void getFittedExportList2(HttpServletResponse response, StandardExportDTO standardExportDTO) throws Exception;
    void getFittedExportList3(HttpServletResponse response, StandardExportDTO standardExportDTO) throws Exception;
}
