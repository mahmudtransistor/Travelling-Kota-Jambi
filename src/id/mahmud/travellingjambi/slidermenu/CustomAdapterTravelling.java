package id.mahmud.travellingjambi.slidermenu;

import java.util.ArrayList;
import java.util.List;

import id.mahmud.travellingjambi.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapterTravelling extends BaseAdapter implements Filterable {
	
	private Context context;
	private List<RowItemTravelling>list,filterd;
	
	public CustomAdapterTravelling(Context context, List<RowItemTravelling>list){
		this.context = context;
		this.list = list;
		this.filterd = this.list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return filterd.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return filterd.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null){
			LayoutInflater inflater = LayoutInflater.from(this.context);
			convertView = inflater.inflate(R.layout.list_travelling, null);
			
		}
		RowItemTravelling Travelling = filterd.get(position);
		ImageView gambar = (ImageView)convertView.findViewById(R.id.imagetravelling);
		gambar.setImageResource(Travelling.getGambar());
		TextView namatravelling = (TextView)convertView.findViewById(R.id.txtnamatravelling);
		namatravelling.setText(Travelling.getNama_travelling());
		TextView keterangan = (TextView)convertView.findViewById(R.id.txtketerangantravelling);
		keterangan.setText(Travelling.getKeterangan());
		
		return convertView;
	}

	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		RowItemTravellingFilter filter = new RowItemTravellingFilter();
		return filter;
	}
	public class RowItemTravellingFilter extends Filter{

		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			// TODO Auto-generated method stub
			List<RowItemTravelling>filterdata = new ArrayList<RowItemTravelling>();
			FilterResults result = new FilterResults();
			String FilterString = constraint.toString().toLowerCase();
			for(RowItemTravelling tabel : list){
				if(tabel.getNama_travelling().toLowerCase().contains(FilterString)){
					filterdata.add(tabel);
				}
				
			}
			result.count= filterdata.size();
			result.values= filterdata;
			return result;
		}
		public CharSequence getNama_Travelling(){
			return null;
		}
		

		@Override
		protected void publishResults(CharSequence constraint,
				FilterResults results) {
			// TODO Auto-generated method stub
			filterd =(List<RowItemTravelling>) results.values;
			notifyDataSetChanged();
			
		}
		
	}
	
	

}
