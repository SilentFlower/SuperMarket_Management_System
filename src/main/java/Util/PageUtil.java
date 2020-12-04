package Util;

import Domain.Page;

/**
 * @author SiletFlower
 * @date 2020/11/21 17:04:24
 * @description
 */
public class PageUtil {
    public static Page dealWithPage(Page page,Integer count){
        Integer pageCount = 0;
        page.setCount(count);
        if((count+page.getPageSize()-1)/page.getPageSize() == 0){
            pageCount = 1;
        }else {
            pageCount = (count+page.getPageSize()-1)/page.getPageSize();
        }
        page.setPageCount(pageCount);

        return page;
    }
}
