package com.example.rentacarapptestphase;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CarList extends ArrayAdapter<Car>
{
    private Activity context;
    List<Car> cars;

    public CarList(Activity context, List<Car> cars)
    {
        super(context, R.layout.layout_car_list, cars);//layout_deals_list
        this.context = context;
        this.cars = cars;


    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_car_list, null, true);
//  public Car(int id, String carId, String model, String capacity, String colour, String ownerId, String status)

        TextView id= (TextView) listViewItem.findViewById(R.id.Carid);
        TextView carId = (TextView) listViewItem.findViewById(R.id.CarId1);
        TextView model = (TextView) listViewItem.findViewById(R.id.CarModel);
        TextView capacity = (TextView) listViewItem.findViewById(R.id.CarCapacity);


        TextView colour= (TextView) listViewItem.findViewById(R.id.CarColour);
        TextView ownerId = (TextView) listViewItem.findViewById(R.id.CarOwnerID);
        TextView status = (TextView) listViewItem.findViewById(R.id.CarStatus);



        Car a = cars.get(position);

        id.setText(a.getId());
        carId.setText(a.getCarId());
        model.setText(a.getModel());
        capacity.setText(a.getCapacity());
        colour.setText(a.getColour());
        ownerId.setText(a.getOwnerId());
        status.setText(a.getStatus());





        return listViewItem;
    }









}