import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.Product
import com.example.retrofit.R

class YourAdapter : RecyclerView.Adapter<YourAdapter.ViewHolder>() {
    private var productList: List<Product> = emptyList()

    fun setProductList(productList: List<Product>) {
        this.productList = productList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvId: TextView = itemView.findViewById(R.id.tvProductId)
        val tvTitle: TextView = itemView.findViewById(R.id.tvProductTitle)
        val tvRating: TextView = itemView.findViewById(R.id.tvProductRating)
        val tvPrice: TextView = itemView.findViewById(R.id.tvProductPrice)
        val tvDescription: TextView = itemView.findViewById(R.id.tvProductDescription)
        val tvCategory: TextView = itemView.findViewById(R.id.tvProductCategory)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]

        holder.tvId.text = product.id.toString()
        holder.tvRating.text = product.rating.toString()
        holder.tvTitle.text = product.title
        holder.tvPrice.text = "Price: $${product.price}"
        holder.tvDescription.text = product.description
        holder.tvCategory.text = "Category: ${product.category}"

        // Load image using a library like Picasso, Glide, or any other method
        // For simplicity, you can use the default placeholder for now

    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
