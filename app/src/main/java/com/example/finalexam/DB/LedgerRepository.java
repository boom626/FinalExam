package com.example.finalexam.DB;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class LedgerRepository {
    private Context mContext;

    public LedgerRepository(Context mContext) {
        this.mContext = mContext;
    }

    public void getLedger(Callback callback){
        GetTask getTask = new GetTask(mContext,callback);
        getTask.execute();
    }

    public  void insertLedger(LedgerItem item,InsertCallback callback){
        InsertTask insertTask=new InsertTask(mContext,callback);
        insertTask.execute(item);
    }

    private  static class GetTask extends AsyncTask<Void,Void, List<LedgerItem>>{
        private Context mContext;
        private Callback mCallback;
        public GetTask(Context context,Callback callback){
            this.mContext=context;
            this.mCallback=callback;
        }

        @Override
        protected List<LedgerItem> doInBackground(Void... voids) {
            AppDatabase db = AppDatabase.getInstance(mContext);
            List<LedgerItem> itemList =db.ledgerDao().getAll();
            return itemList;
        }

        @Override
        protected void onPostExecute(List<LedgerItem> itemsList) {
            super.onPostExecute(itemsList);
            mCallback.gettoLoginCallBack(itemsList);
        }
    }// ปิด GetTask
    //-------------------------------------
    public interface Callback{
        void gettoLoginCallBack(List<LedgerItem> LedgerItemList);
    }

    public interface InsertCallback{
        void onInsertCallBack();
    }

    //-------------------------------------
    private static class InsertTask extends AsyncTask<LedgerItem,Void, Void> {
        private Context mContext;
        private InsertCallback mCallback;
        public InsertTask(Context context,InsertCallback mCallback) {
            this.mContext=context;
            this.mCallback=mCallback;
        }

        @Override
        protected Void doInBackground(LedgerItem... ledgerItem) {
            AppDatabase db=AppDatabase.getInstance(mContext);
            db.ledgerDao().insert(ledgerItem[0]); //ถ้าหลายitem วนloop
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mCallback.onInsertCallBack();
        }
    } // ปิด InsertTask
    //-------------------------------------
//    public interface InsertCallback{
//        void onInsertSuccess();
//    }
}
