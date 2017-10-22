package com.mymakecents.artland.artland;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.support.v7.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.mymakecents.artland.artland.models.Artwork;
import com.mymakecents.artland.artland.models.HistoryRecord;
import com.mymakecents.artland.artland.utils.GridDataAdapter;
import com.mymakecents.artland.artland.utils.RecyclerItemClickListener;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private PlaceholderFragment.SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new PlaceholderFragment.SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intentAdd = new Intent(DashboardActivity.this, FlipActivity.class);
                intentAdd.putExtra("username", "michelangelo");
                startActivity(intentAdd);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

//        final MenuItem searchItem = menu.findItem(R.id.action_search);
//
//        if (searchItem != null) {
//            searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
//            searchView.setOnCloseListener(new SearchView.OnCloseListener() {
//                @Override
//                public boolean onClose() {
//                    //some operation
//                }
//            });
//            searchView.setOnSearchClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //some operation
//                }
//            });
//            EditText searchPlate = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
//            searchPlate.setHint("Search");
//            View searchPlateView = searchView.findViewById(android.support.v7.appcompat.R.id.search_plate);
//            searchPlateView.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent));
//            // use this method for search process
//            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//                @Override
//                public boolean onQueryTextSubmit(String query) {
//                    // use this method when query submitted
//                    Toast.makeText(context, query, Toast.LENGTH_SHORT).show();
//                    return false;
//                }
//
//                @Override
//                public boolean onQueryTextChange(String newText) {
//                    // use this method for auto complete search process
//                    return false;
//                }
//            });
//            SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
//            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

            return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

/**
 * A placeholder fragment containing a simple view.
 */
@SuppressLint("ValidFragment")
class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private final String recyclerViewTitleText[] = {"Love Bird", "Bridge", "Man in Red", "Mother", "Water Lily", "House", "Example", "CardView", "Lollipop", "Marshmallow"
    };

    private final int recyclerViewImages[] = {
            R.drawable.g1, R.drawable.g2, R.drawable.g3, R.drawable.g4, R.drawable.g5, R.drawable.g1,
            R.drawable.g4, R.drawable.g5, R.drawable.g4, R.drawable.g2

    };

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

        // Call for data
        initRecyclerViews(rootView);

        return rootView;
    }


    private void initRecyclerViews(View rootView) {
        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<Artwork> artworksList = prepareData();
        GridDataAdapter mAdapter = new GridDataAdapter(getActivity().getApplicationContext(), artworksList);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity().getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int i) {
                        switch (i) {
                            case 0:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 1:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 3:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 4:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 5:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 6:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 7:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 8:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 9:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 10:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 11:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                        }
                    }
                })
        );
    }
    private ArrayList<Artwork> prepareData() {

        ArrayList<Artwork> av = new ArrayList<>();
//        for (int i = 0; i < recyclerViewTitleText.length; i++) {
        for (int i = 0; i < recyclerViewTitleText.length; i++) {
//                AndroidVersion mAndroidVersion = new AndroidVersion();
//                mAndroidVersion.setAndroidVersionName(recyclerViewTitleText[i]);
//                mAndroidVersion.setrecyclerViewImage(recyclerViewImages[i]);
//                av.add(mAndroidVersion);
            HistoryRecord historyRecord = new HistoryRecord(i+""); // yes i know
            historyRecord.setDescription("Description");

            Artwork artwork = new Artwork(i+"");
            artwork.setArtistName(recyclerViewTitleText[i]);
            artwork.setPhotoId(recyclerViewImages[i]);
            artwork.addHistoryRecords(historyRecord);
            av.add(artwork);
        }
        return av;
    }
    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public static class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Published";
                case 1:
                    return "In Progress";
//                case 2:
//                    return "SECTION 3";
            }
            return null;
        }
    }

}
