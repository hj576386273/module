package com.demo.tool.utils;

import org.jxls.common.Context;
import org.jxls.expression.JexlExpressionEvaluator;
import org.jxls.transform.Transformer;
import org.jxls.transform.poi.PoiTransformer;
import org.jxls.util.JxlsHelper;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjian
 * @version 1.0
 * @Description TODO
 * @date 2018/4/17
 */
public class JxlsUtils {

    private static final String TEMPLATE_PATH="templates/excel";

    public static void download(HttpServletResponse response, String templateName, String exportName, Map<String, Object> data) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        OutputStream os = response.getOutputStream();
        exportName = new String(exportName.getBytes("utf-8"), "ISO-8859-1");
        // 组装附件名称和格式
        response.setHeader("Content-disposition", "attachment; filename=" + exportName + ".xls");
        JxlsUtils.exportExcel(templateName, os, data);
        os.close();
    }
    
    public static void download(String templateName, String exportName, Map<String, Object> data) throws Exception {
    	HttpServletResponse response = RequestContextUtils.getResponse();
    	response.setContentType("application/vnd.ms-excel");

        try (OutputStream os = response.getOutputStream()) {
            exportName = new String(exportName.getBytes("utf-8"), "ISO-8859-1");
            // 组装附件名称和格式
            response.setHeader("Content-disposition", "attachment; filename=" + exportName + ".xls");
            JxlsUtils.exportExcel(templateName, os, data);
        }
    }

    public static void exportExcel(InputStream is, OutputStream os, Map<String, Object> model) throws IOException{
        Context context = PoiTransformer.createInitialContext();
        if (model != null) {
            for (String key : model.keySet()) {
                context.putVar(key, model.get(key));
            }
        }
        JxlsHelper jxlsHelper = JxlsHelper.getInstance();
        Transformer transformer  = jxlsHelper.createTransformer(is, os);
        //获得配置
        JexlExpressionEvaluator evaluator = (JexlExpressionEvaluator)transformer.getTransformationConfig().getExpressionEvaluator();
        //设置静默模式，不报警告
        // evaluator.getJexlEngine().setSilent(true);
        // 函数强制，自定义功能
        Map<String, Object> funcs = new HashMap<>();
        //添加自定义功能
        funcs.put("utils", new JxlsUtils());
        evaluator.getJexlEngine().setFunctions(funcs);
        //必须要这个，否者表格函数统计会错乱
        jxlsHelper.setUseFastFormulaProcessor(false).processTemplate(context, transformer);
    }

    public static void exportExcel(File xls, File out, Map<String, Object> model) throws FileNotFoundException, IOException {
        exportExcel(new FileInputStream(xls), new FileOutputStream(out), model);
    }

    public static void exportExcel(String templateName, OutputStream os, Map<String, Object> model) throws Exception {
    	InputStream template = getTemplate(templateName);
        if (template != null) {
            exportExcel(template, os, model);
        } else {
            throw new Exception("Excel 模板未找到。");
        }
    }

    //获取jxls模版文件
    public static InputStream getTemplate(String fileName) throws Exception{
        //File template = ResourceUtils.getFile("classpath:"+path);
    	InputStream inputStream = ResourceUtils.getResourceClassPath(TEMPLATE_PATH + "/" + fileName).getInputStream();
        return inputStream;
    }

    // 日期格式化
    public String dateFmt(Date date, String fmt) {
        if (date == null) {
            return "";
        }
        try {
            SimpleDateFormat dateFmt = new SimpleDateFormat(fmt);
            return dateFmt.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    // if判断
    public Object ifelse(boolean b, Object o1, Object o2) {
        return b ? o1 : o2;
    }
}
