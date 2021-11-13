package com.nhpva.shopping.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nhpva.shopping.R;
import com.nhpva.shopping.adapter.HorizontalProductAdapter;
import com.nhpva.shopping.adapter.PageIndicatorAdapter;
import com.nhpva.shopping.adapter.VerticalProductAdapter;
import com.nhpva.shopping.model.Product;
import com.nhpva.shopping.viewmodel.ProductViewModel;
import com.nhpva.shopping.viewmodel.ProductViewModelFactory;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private static HomeFragment INSTANCE;
    private ProductViewModel viewModel;
    private List<Product> mProducts;
    private List<String> imgEvents;
    private HorizontalProductAdapter horizontalProductAdapter;
    private VerticalProductAdapter verticalProductAdapter;
    private RecyclerView rvSellingProduct;
    private RecyclerView rvFlashSale;
    private RecyclerView rvRecommend;
    private ViewPager vpEvents;
    private DotsIndicator dotsIndicator;
    private PageIndicatorAdapter pageIndicatorAdapter;
    private ImageView imgCart;

    public static HomeFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HomeFragment();
        }
        return INSTANCE;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initViews(view);
        imgEvents = new ArrayList<>();
        pageIndicatorAdapter = new PageIndicatorAdapter(imgEvents, getContext());
        vpEvents.setAdapter(pageIndicatorAdapter);
        dotsIndicator.setViewPager(vpEvents);

        mProducts = new ArrayList<>();
        horizontalProductAdapter = new HorizontalProductAdapter(mProducts);
        verticalProductAdapter = new VerticalProductAdapter(mProducts);

        addData();

        rvFlashSale.setAdapter(horizontalProductAdapter);
        rvSellingProduct.setAdapter(horizontalProductAdapter);
        rvRecommend.setAdapter(verticalProductAdapter);
        rvFlashSale.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        rvSellingProduct.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        rvRecommend.setLayoutManager(new GridLayoutManager(getContext(), 2));

        imgCart.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity().getApplication(), CartActivity.class);
            startActivity(intent);
        });
        return view;
    }

    private void initViews(View view) {
        imgCart = view.findViewById(R.id.img_cart);
        dotsIndicator = view.findViewById(R.id.dots_indicator_event);
        vpEvents = view.findViewById(R.id.vp_event);
        rvSellingProduct = view.findViewById(R.id.rv_selling_products);
        rvFlashSale = view.findViewById(R.id.rv_flash_sale);
        rvRecommend = view.findViewById(R.id.rv_recommend);
    }

    private void addData(){
        imgEvents.add("https://i.ytimg.com/vi/YZLJcoJgUSE/maxresdefault.jpg");
        imgEvents.add("https://techtimes.vn/wp-content/uploads/2019/02/Galaxy-s10e-techtimes.jpg");
        imgEvents.add("https://cellphones.com.vn/sforum/wp-content/uploads/2021/02/Huawei-Mate-X2-poster-face-960x505.jpg");
        imgEvents.add("https://www.xtmobile.vn/vnt_upload/news/08_2019/mau-sac-tren-xiaomi-mi-10-lite-5g-xtmobile.jpg");
        imgEvents.add("https://lh3.googleusercontent.com/proxy/8cmMB29OIDenAk8s9X9ZkYQEvxa_ZMQECCLoAcDevQ6g1_4FnyU7Zv7bpv-g-CQHvvV7Bit6gcFHq4Z58vox41L-ana3XnglagxDSA4FB383_ulGqvk5UDVWWxtgssHZ3XgWO-ARlCy_qzITn_bXc_2q5KyoGdWCD0jtH55NJdjG");

        pageIndicatorAdapter.notifyDataSetChanged();

        mProducts.add( new Product("VSMart 3", 10000, 4, "https://cdn-www.vinid.net/2020/09/adec03ae-vsmart-active-3.jpg"));
        mProducts.add( new Product("Samsung", 1000, 2, "https://cdn.tgdd.vn/Products/Images/42/225063/sam-sung-note-20-ultra-vang-dong-200x200.jpg"));
        mProducts.add( new Product("Honor V30", 5000, 3, "https://cdn-www.vinid.net/2020/09/3554edc5-honor-v30-1024x529.jpg"));
        mProducts.add( new Product("Iphone11Promax", 20000, 2, "https://cdn-www.vinid.net/2020/09/08056f5e-iphone-11-promax-1024x683.jpg"));
        mProducts.add( new Product("Iphone12Promax", 25000, 2, "https://img.websosanh.vn/v2/users/review/images/g0uimocg53p63.jpg?compress=85"));
        mProducts.add( new Product("Vivo", 1000, 2, "https://www.vivosmartphone.vn/uploads/MANGOADS/vivo%20S1/l%E1%BB%A3i%20%C3%ADch/2.jpg"));



        horizontalProductAdapter.notifyDataSetChanged();
        verticalProductAdapter.notifyDataSetChanged();
    }


}