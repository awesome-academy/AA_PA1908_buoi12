package vn.sunasterisk.buoi11_implicitintentandmenu.screen.main;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;

import vn.sunasterisk.buoi11_implicitintentandmenu.R;
import vn.sunasterisk.buoi11_implicitintentandmenu.base.BaseActivity;
import vn.sunasterisk.buoi11_implicitintentandmenu.screen.contact.ContactFragment;

public class MainActivity extends BaseActivity {


    /**
     * menu: co 3 loai:
     * - OptionMenu:
     * - ContextMenu:
     * - PopupMenu
     */

    private ContactFragment mContactFragment;

    private ActionBar mActionBar;

    @Override
    protected void registerListeners() {

    }

    @Override
    protected void initComponents() {
        initActionbar();
        addContactFragment();
    }

    private void initActionbar() {
        mActionBar = getSupportActionBar();
        mActionBar.setTitle("Android");
    }

    private void addContactFragment() {
        mContactFragment = new ContactFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container, mContactFragment)
                .commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_android:
                Toast.makeText(this, "Android", Toast.LENGTH_SHORT).show();
                mActionBar.setTitle("Android");
                return true;
            case R.id.item_ios:
                Toast.makeText(this, "IOS", Toast.LENGTH_SHORT).show();
                mActionBar.setTitle("IOS");
                return true;
            case R.id.item_Php:
                Toast.makeText(this, "Php", Toast.LENGTH_SHORT).show();
                mActionBar.setTitle("Php");
                return true;
            case R.id.item_Ruby:
                Toast.makeText(this, "Ruby", Toast.LENGTH_SHORT).show();
                mActionBar.setTitle("Ruby");
                return true;
            case R.id.item_java:
                Toast.makeText(this, "Java", Toast.LENGTH_SHORT).show();
                mActionBar.setTitle("Java");
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
