/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-07-30 17:15:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.chart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/chart/../include/mainHeader.jsp", Long.valueOf(1468940156000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.release();
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--\r\n");
      out.write("This is a starter template page. Use this page to start your new project from\r\n");
      out.write("scratch. This page gets rid of all links and provides the needed markup only.\r\n");
      out.write("-->\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <title>凯盛CRM | 统计</title>\r\n");
      out.write("    <!-- Tell the browser to be responsive to screen width -->\r\n");
      out.write("    <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\r\n");
      out.write("    <!-- Bootstrap 3.3.6 -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("    <!-- Font Awesome -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/plugins/fontawesome/css/font-awesome.min.css\">\r\n");
      out.write("    <!-- Theme style -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/dist/css/AdminLTE.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/dist/css/skins/skin-blue.min.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"hold-transition skin-blue sidebar-mini\">\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Main Header -->\r\n");
      out.write("<header class=\"main-header\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Logo -->\r\n");
      out.write("    <a href=\"index2.html\" class=\"logo\">\r\n");
      out.write("        <!-- mini logo for sidebar mini 50x50 pixels -->\r\n");
      out.write("        <span class=\"logo-mini\">CRM</span>\r\n");
      out.write("        <!-- logo for regular state and mobile devices -->\r\n");
      out.write("        <span class=\"logo-lg\"><b>Kaisheng</b>CRM</span>\r\n");
      out.write("    </a>\r\n");
      out.write("\r\n");
      out.write("    <!-- Header Navbar -->\r\n");
      out.write("    <nav class=\"navbar navbar-static-top\" role=\"navigation\">\r\n");
      out.write("        <!-- Sidebar toggle button-->\r\n");
      out.write("        <a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"offcanvas\" role=\"button\">\r\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <!-- Navbar Right Menu -->\r\n");
      out.write("        <div class=\"navbar-custom-menu\">\r\n");
      out.write("            <ul class=\"nav navbar-nav\">\r\n");
      out.write("                <!-- User Account Menu -->\r\n");
      out.write("                <li class=\"dropdown\">\r\n");
      out.write("                    <!-- Menu Toggle Button -->\r\n");
      out.write("                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("                        <span class=\"hidden-xs\">");
      if (_jspx_meth_shiro_005fprincipal_005f0(_jspx_page_context))
        return;
      out.write("</span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li><a href=\"/user/password\">修改密码</a></li>\r\n");
      out.write("                        <li><a href=\"/user/log\">登录日志</a></li>\r\n");
      out.write("                        <li class=\"divider\"></li>\r\n");
      out.write("                        <li><a href=\"/logout\">安全退出</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/leftSidebar.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("menu", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("chart", request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Content Wrapper. Contains page content -->\r\n");
      out.write("    <div class=\"content-wrapper\">\r\n");
      out.write("        <!-- Main content -->\r\n");
      out.write("        <section class=\"content\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"box box-primary\">\r\n");
      out.write("                <div class=\"box-header\">\r\n");
      out.write("                    <h3 class=\"box-title\">统计区间</h3>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"box-body\">\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-4\">\r\n");
      out.write("                    <div class=\"info-box\">\r\n");
      out.write("                        <!-- Apply any bg-* class to to the icon to color it -->\r\n");
      out.write("                        <span class=\"info-box-icon bg-aqua\"><i class=\"fa fa-plus\"></i></span>\r\n");
      out.write("                        <div class=\"info-box-content\">\r\n");
      out.write("                            <span class=\"info-box-text\">本月新增客户数量</span>\r\n");
      out.write("                            <span class=\"info-box-number\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${newCustomerCount}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("                        </div><!-- /.info-box-content -->\r\n");
      out.write("                    </div><!-- /.info-box -->\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-4\">\r\n");
      out.write("                    <div class=\"info-box\">\r\n");
      out.write("                        <!-- Apply any bg-* class to to the icon to color it -->\r\n");
      out.write("                        <span class=\"info-box-icon bg-green\"><i class=\"fa fa-flag\"></i></span>\r\n");
      out.write("                        <div class=\"info-box-content\">\r\n");
      out.write("                            <span class=\"info-box-text\">本月完成交易次数</span>\r\n");
      out.write("                            <span class=\"info-box-number\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${saleCount}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("                        </div><!-- /.info-box-content -->\r\n");
      out.write("                    </div><!-- /.info-box -->\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-4\">\r\n");
      out.write("                    <div class=\"info-box\">\r\n");
      out.write("                        <!-- Apply any bg-* class to to the icon to color it -->\r\n");
      out.write("                        <span class=\"info-box-icon bg-red\"><i class=\"fa fa-money\"></i></span>\r\n");
      out.write("                        <div class=\"info-box-content\">\r\n");
      out.write("                            <span class=\"info-box-text\">本月交易额</span>\r\n");
      out.write("                            <span class=\"info-box-number\">￥");
      if (_jspx_meth_fmt_005fformatNumber_005f0(_jspx_page_context))
        return;
      out.write(" </span>\r\n");
      out.write("                        </div><!-- /.info-box-content -->\r\n");
      out.write("                    </div><!-- /.info-box -->\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"box box-primary\">\r\n");
      out.write("                <div class=\"box-header\">\r\n");
      out.write("                    <h3 class=\"box-title\">销售机会统计</h3>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"box-body\">\r\n");
      out.write("                    <div id=\"pieChart\" style=\"width: 100%;height: 300px\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"box box-primary\">\r\n");
      out.write("                <div class=\"box-header\">\r\n");
      out.write("                    <h3 class=\"box-title\">员工业绩图</h3>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"box-body\">\r\n");
      out.write("                    <div id=\"barChart\" style=\"width: 100%;height: 300px\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </section>\r\n");
      out.write("        <!-- /.content -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /.content-wrapper -->\r\n");
      out.write("</div>\r\n");
      out.write("<!-- ./wrapper -->\r\n");
      out.write("\r\n");
      out.write("<!-- REQUIRED JS SCRIPTS -->\r\n");
      out.write("\r\n");
      out.write("<!-- jQuery 2.2.0 -->\r\n");
      out.write("<script src=\"/static/plugins/jQuery/jQuery-2.2.0.min.js\"></script>\r\n");
      out.write("<!-- Bootstrap 3.3.6 -->\r\n");
      out.write("<script src=\"/static/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!-- AdminLTE App -->\r\n");
      out.write("<script src=\"/static/plugins/echart/echarts.common.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    $(function(){\r\n");
      out.write("        //饼图\r\n");
      out.write("        var pieChart = echarts.init($(\"#pieChart\")[0]);\r\n");
      out.write("        var pieOption = {\r\n");
      out.write("            tooltip : {\r\n");
      out.write("                trigger: 'item',\r\n");
      out.write("                formatter: \"{a} <br/>{b} : {c} ({d}%)\"\r\n");
      out.write("            },\r\n");
      out.write("            series : [\r\n");
      out.write("                {\r\n");
      out.write("                    name: '销售机会',\r\n");
      out.write("                    type: 'pie',\r\n");
      out.write("                    data:[],\r\n");
      out.write("                    itemStyle: {\r\n");
      out.write("                        emphasis: {\r\n");
      out.write("                            shadowBlur: 10,\r\n");
      out.write("                            shadowOffsetX: 0,\r\n");
      out.write("                            shadowColor: 'rgba(0, 0, 0, 0.5)'\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            ]\r\n");
      out.write("        };\r\n");
      out.write("        pieChart.setOption(pieOption);\r\n");
      out.write("        $.get(\"/chart/progress/data\",function(data){\r\n");
      out.write("            pieChart.setOption({\r\n");
      out.write("                series: [{\r\n");
      out.write("                    data: data\r\n");
      out.write("                }]\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        //柱状图\r\n");
      out.write("        var barChar=echarts.init($(\"#barChart\")[0]);\r\n");
      out.write("        //制定图表的配置项和数据\r\n");
      out.write("        var option={\r\n");
      out.write("            tooltip:{},\r\n");
      out.write("            xAxis:{\r\n");
      out.write("                data:[]\r\n");
      out.write("            },\r\n");
      out.write("            yAxis:{},\r\n");
      out.write("            series:[{\r\n");
      out.write("                name:'业绩',\r\n");
      out.write("                type:'bar',\r\n");
      out.write("                data:[]\r\n");
      out.write("            }]\r\n");
      out.write("        };\r\n");
      out.write("        //使用指定的配置项和数据显示图标\r\n");
      out.write("        barChar.setOption(option);\r\n");
      out.write("        $.get(\"/chart/user/money\",function(data){\r\n");
      out.write("            barChar.setOption({\r\n");
      out.write("                xAxis:{\r\n");
      out.write("                    data:data.names\r\n");
      out.write("                },\r\n");
      out.write("                series:[{\r\n");
      out.write("                    data:data.values\r\n");
      out.write("                }]\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_shiro_005fprincipal_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  shiro:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shiro_005fprincipal_005f0 = (org.apache.shiro.web.tags.PrincipalTag) _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shiro_005fprincipal_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fprincipal_005f0.setParent(null);
    // /WEB-INF/views/chart/../include/mainHeader.jsp(27,48) name = property type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fprincipal_005f0.setProperty("realname");
    int _jspx_eval_shiro_005fprincipal_005f0 = _jspx_th_shiro_005fprincipal_005f0.doStartTag();
    if (_jspx_th_shiro_005fprincipal_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.reuse(_jspx_th_shiro_005fprincipal_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fprincipal_0026_005fproperty_005fnobody.reuse(_jspx_th_shiro_005fprincipal_005f0);
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatNumber_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_005fformatNumber_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_005fformatNumber_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatNumber_005f0.setParent(null);
    // /WEB-INF/views/chart/home.jsp(72,59) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatNumber_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${saleMoney}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_fmt_005fformatNumber_005f0 = _jspx_th_fmt_005fformatNumber_005f0.doStartTag();
    if (_jspx_th_fmt_005fformatNumber_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f0);
    return false;
  }
}