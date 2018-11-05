// IBookAidlInterface.aidl
package com.review.android;

// Declare any non-default types here with import statements

import com.review.android.ipc.aidl.Book;

interface IBookAidlInterface {


     void addPerson(in Book book);

     List<Book> getBookList();
}
