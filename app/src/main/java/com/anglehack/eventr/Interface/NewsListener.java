package com.anglehack.eventr.Interface;

import com.anglehack.eventr.Base.News;

/**
 * Created by Adham32 on 10.06.2017.
 */

public interface NewsListener {

    void newNewsRecive(News news);

    void setNewsMainInfo(News news);
}
