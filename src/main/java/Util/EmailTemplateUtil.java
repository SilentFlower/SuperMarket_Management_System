package Util;

/**
 * @author SiletFlower
 * @date 2020/12/13 22:21:32
 * @description
 */
public class EmailTemplateUtil {

    public static String emailTemplate(String s) {
        StringBuilder ss = new StringBuilder();
        ss.append("<!DOCTYPE html>\n" +
                "<html lang=\"zh-CN\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>库存警告</title>\n" +
                "    <style type=\"text/css\">\n" +
                "        img {\n" +
                "            max-width: 100%;\n" +
                "        }\n" +
                "\n" +
                "        body {\n" +
                "            -webkit-font-smoothing: antialiased;\n" +
                "            -webkit-text-size-adjust: none;\n" +
                "            width: 100% !important;\n" +
                "            height: 100%;\n" +
                "            line-height: 1.6em;\n" +
                "        }\n" +
                "\n" +
                "        body {\n" +
                "            background-color: #f6f6f6;\n" +
                "        }\n" +
                "\n" +
                "        @media only screen and (max-width: 640px) {\n" +
                "            body {\n" +
                "                padding: 0 !important;\n" +
                "            }\n" +
                "\n" +
                "            h1 {\n" +
                "                font-weight: 800 !important;\n" +
                "                margin: 20px 0 5px !important;\n" +
                "            }\n" +
                "\n" +
                "            h2 {\n" +
                "                font-weight: 800 !important;\n" +
                "                margin: 20px 0 5px !important;\n" +
                "            }\n" +
                "\n" +
                "            h3 {\n" +
                "                font-weight: 800 !important;\n" +
                "                margin: 20px 0 5px !important;\n" +
                "            }\n" +
                "\n" +
                "            h4 {\n" +
                "                font-weight: 800 !important;\n" +
                "                margin: 20px 0 5px !important;\n" +
                "            }\n" +
                "\n" +
                "            h1 {\n" +
                "                font-size: 22px !important;\n" +
                "            }\n" +
                "\n" +
                "            h2 {\n" +
                "                font-size: 18px !important;\n" +
                "            }\n" +
                "\n" +
                "            h3 {\n" +
                "                font-size: 16px !important;\n" +
                "            }\n" +
                "\n" +
                "            .container {\n" +
                "                padding: 0 !important;\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "\n" +
                "            .content {\n" +
                "                padding: 0 !important;\n" +
                "            }\n" +
                "\n" +
                "            .content-wrap {\n" +
                "                padding: 10px !important;\n" +
                "            }\n" +
                "\n" +
                "            .invoice {\n" +
                "                width: 100% !important;\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>" +
                "<body itemscope itemtype=\"http://schema.org/EmailMessage\"\n" +
                "    style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; width: 100% !important; height: 100%; line-height: 1.6em; background-color: #f6f6f6; margin: 0;\"\n" +
                "    bgcolor=\"#f6f6f6\">\n" +
                "    <table class=\"body-wrap\"\n" +
                "        style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; width: 100%; background-color: #f6f6f6; margin: 0;\"\n" +
                "        bgcolor=\"#f6f6f6\">\n" +
                "        <tr\n" +
                "            style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\n" +
                "            <td style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0;\"\n" +
                "                valign=\"top\">\n" +
                "            </td>\n" +
                "            <td class=\"container\" width=\"600\"\n" +
                "                style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; display: block !important; max-width: 600px !important; clear: both !important; margin: 0 auto;\"\n" +
                "                valign=\"top\">\n" +
                "                <div class=\"content\"\n" +
                "                    style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; max-width: 600px; display: block; margin: 0 auto; padding: 20px;\">\n" +
                "                    <table class=\"main\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                        style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; border-radius: 3px; background-color: #fff; margin: 0; border: 1px solid #e9e9e9;\"\n" +
                "                        bgcolor=\"#fff\">\n" +
                "                        <tr\n" +
                "                            style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\n" +
                "                            <td class=\"alert alert-warning\"\n" +
                "                                style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 22px; font-weight: bold; vertical-align: top; color: #fff; font-weight: 500; text-align: center; border-radius: 3px 3px 0 0; background-color: #0073ba; margin: 0; padding: 20px;\"\n" +
                "                                align=\"center\" bgcolor=\"#0073ba\" valign=\"top\">\n" +
                "                                库存警告\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                        <tr\n" +
                "                            style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\n" +
                "                            <td class=\"content-wrap\"\n" +
                "                                style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 20px;\"\n" +
                "                                valign=\"top\">\n" +
                "                                <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                    style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\n" +
                "                                    <tr\n" +
                "                                        style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\n" +
                "                                        <td class=\"content-block\"\n" +
                "                                            style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 34px; vertical-align: top; line-height: 1em; margin: 0; padding: 20px 0 30px;\"\n" +
                "                                            valign=\"top\">\n" +
                "                                            Dear Admin\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    <tr\n" +
                "                                        style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\n" +
                "                                        <td class=\"content-block\"\n" +
                "                                            style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 16px; color: #4a4a4a; vertical-align: top; margin: 0; padding: 0 0 20px;\"\n" +
                "                                            valign=\"top\">");
        ss.append(s);
        ss.append("</td>\n" +
                "                                    </tr>\n" +
                "                                    <tr\n" +
                "                                        style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\n" +
                "                                        <td class=\"content-block\"\n" +
                "                                            style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 12px; color: #757575; vertical-align: top; margin: 0; padding: 0 0 20px;\"\n" +
                "                                            valign=\"top\">\n" +
                "                                            (本邮件由系统自动发出，请勿直接回复)\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    <tr\n" +
                "                                        style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\">\n" +
                "                                        <td class=\"content-block\"\n" +
                "                                            style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; text-align: center; vertical-align: top; margin: 0; padding: 0 0 20px;\"\n" +
                "                                            valign=\"top\">\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                </table>\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                    </table>\n" +
                "            </td>\n" +
                "            <td style=\"font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0;\"\n" +
                "                valign=\"top\">\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</body>\n" +
                "\n" +
                "</html>");
        return ss.toString();
    }
}
