package layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kroger.classdemoapp.R
import com.kroger.classdemoapp.Transformer

class CharacterAdapter (private val transformers: List<Transformer>) : RecyclerView.Adapter<CharacterAdapter.transformerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): transformerViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.character_card_view, parent, false)
        return transformerViewHolder(view)
    }

    override fun getItemCount() = transformers.size

    override fun onBindViewHolder(holder: transformerViewHolder, position: Int) {
        val character = transformers[position]
        holder.characterImage.setImageResource(Transformer.image)
        holder.characterName.text = character.name
        holder.characterAlliance.text = character.alliance
    }

    class transformerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val characterImage: ImageView = itemView.findViewById(R.id.characterImage)
        val characterName: TextView = itemView.findViewById(R.id.characterName)
        val characterAlliance: TextView = itemView.findViewById(R.id.characterAlliance)
        val characterVehicle: TextView = itemView.findViewById(R.id.characterVehicle)
        //val characterHeight: TextView = itemView.findViewById(R.id.cha)
        //todo
    }
}