package com.android.dars.base.modules.main;


import com.android.dars.base.data.Contact;

import java.util.ArrayList;


public interface MainFragmentView {
    void setContactsAdapter(ArrayList<Contact> contacts);
    void onFailure();
}
