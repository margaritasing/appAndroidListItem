package com.alain.cursos.top;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.containerMain)
    CoordinatorLayout containerMain;

    private ArtistaAdapter adapter;

    public static final Artista sArtista = new Artista();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        configToolbar();
        configAdapter();
        configRecyclerView();

        generateArtist();
    }

    private void generateArtist() {
        String[] nombres = {"Rachel", "Mary Elizabeth", "Jessica", "Gal"};
        String[] apellidos = {"McAdams", "Winstead", "Chastain", "Gadot"};
        long[] nacimientos = {280108800000L, 470469600000L, 228031200000L, 483667200000L};
        String[] lugares = {"Canada", "USA", "USA", "Israel"};
        short[] estaturas = {163, 173, 163, 178};
        String[] notas = {"Rachel Anne McAdams was born on November 17, 1978 in London, Ontario, Canada, to Sandra Kay (Gale), a nurse, and Lance Frederick McAdams, a truck driver and furniture mover. She is of English, Welsh, Irish, and Scottish descent. Rachel became involved with acting as a teenager and by the age of 13 was performing in Shakespearean productions in summer theater camp; she went on to graduate with honors with a BFA degree in Theater from York University. After her debut in an episode of Disney's The Famous Jett Jackson (1998), she co-starred in the Canadian TV series Slings and Arrows (2003), a comedy-drama about the trials and travails of a Shakespearean theater group, and won a Gemini award for her performance in 2003.\nHer breakout role as Regina George in the hit comedy Chicas pesadas (2004) instantly catapulted her onto the short list of Hollywood's hottest young actresses. She followed that film with a star turn opposite Ryan Gosling in the adaptation of the Nicholas Sparks bestseller Diario de una pasión (2004), which was a surprise box office success and became the predominant romantic drama for a new, young generation of moviegoers. After filming, McAdams and Gosling became romantically involved and dated through mid-2007. McAdams next showcased her versatility onscreen with the manic comedy Los cazanovias (2005), the thriller Vuelo nocturno (2005), and the holiday drama The Family Stone (2005).\nMcAdams then explored the independent film world with Infieles (2007), which premiered at the Toronto Film Festival and also starred Pierce Brosnan, Chris Cooper and Patricia Clarkson. Starring roles in the military drama The Lucky Ones (2008), the newspaper thriller Los secretos del poder (2009), and the romance Te amaré por siempre (2009) followed before she starred opposite Robert Downey Jr. and Jude Law in Guy Ritchie's international blockbuster Sherlock Holmes (2009). McAdams played the plucky producer of a failing morning TV show in Morning Glory (2010), the materialistic fiancée of Owen Wilson in Woody Allen's Medianoche en París (2011), and returned to romantic drama territory with the hit film Votos de amor (2012) opposite Channing Tatum. The actress also stars with Ben Affleck in Terrence Malick's Deberás amar (2012) and alongside Noomi Rapace in Brian De Palma's thriller Pasión, un asesinato perfecto (2012).\nIn 2005, McAdams received ShoWest's \"Supporting Actress of the Year\" Award as well as the \"Breakthrough Actress of the Year\" at the Hollywood Film Awards. In 2009, she was awarded with ShoWest's \"Female Star of the Year.\" As of 2011, she has been romantically linked with her Medianoche en París (2011) co-star Michael Sheen.",
                "Mary Elizabeth Winstead is a gifted actress, known for her versatile work in a variety of film and television projects. Possibly most known for her role as Ramona Flowers in Scott Pilgrim contra el mundo (2010), she has also starred in critically acclaimed independent films such as Tocando fondo (2012), for which she received an Independent Spirit Award nomination, as well as genre fare like Destino final 3 (2006) and Quentin Tarantino's Death Proof (2007).",
                "Jessica Michelle Chastain was born in Sacramento, California, and was raised in a middle-class household in a northern California suburb. Her mother, Jerri Chastain, is a vegan chef whose family is originally from Kansas, and her stepfather is a fireman. She discovered dance at the age of nine and was in a dance troupe by age thirteen. She began performing in Shakespearean productions all over the Bay area.",
                "Gal Gadot is an Israeli actress, singer, martial artist, and model. She was born in Rosh Ha'ayin, Israel, to an Ashkenazi Jewish family. Her parents are Irit, a teacher, and Michael, an engineer, who is a sixth-generation Israeli. She served in the IDF for two years, and won the Miss Israel title in 2004.\nGal began modeling in the late 2000s, and made her film debut in the fourth film of the Fast and Furious franchise, Rápidos y furiosos (2009), as Gisele. Her role was expanded in the sequels Rápidos y Furiosos: 5in control (2011) and Rápidos y furiosos 6 (2013), in which her character was romantically linked to Han Seoul-Oh (Sung Kang). In the films, Gal performed her own stunts. She also appeared in the 2010 films Una noche fuera de serie (2010) and Knight and Day (2010).\nIn early December 2013, Gal was cast as Wonder Woman in the superhero team-up film Batman vs. Superman: El origen de la justicia (2016), and filming began in 2014 for a March 2016 release. Gadot received swordsmanship, Kung Fu kickboxing, Capoeira and Brazilian Jiu-Jitsu training in preparation for the role. As a result, her performance as the superhero, which is the first time for the character on film, was hailed as one of the best parts of the otherwise poorly-received film. The film is part of the DC Extended Universe, and Gadot plays the role again in the solo film Mujer Maravilla (2017), which was received very positively, and superhero team-up Justice League (2017).\nGal is a motorcycle enthusiast, and owns a black 2006 Ducati Monster-S2R. She has been married to Israeli businessman Yaron Versano since September 28, 2008. They have two daughters."};
        String[] fotos = {"https://upload.wikimedia.org/wikipedia/commons/6/6a/Rachel_McAdams_-_Photoshoot_at_Spotlight%27s_Japan_Premiere_2016.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/7/7b/Mary_Elizabeth_Winstead.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/SDCC_2015_-_Jessica_Chastain_%2819544181630%29.jpg/1024px-SDCC_2015_-_Jessica_Chastain_%2819544181630%29.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Gal_Gadot_%2835402074433%29.jpg/1024px-Gal_Gadot_%2835402074433%29.jpg"};
        for (int i = 0; i < 4; i++) {
            Artista artista = new Artista(i + 1, nombres[i], apellidos[i], nacimientos[i], lugares[i],
                    estaturas[i], notas[i], i + 1, fotos[i]);
            adapter.add(artista);
        }
    }

    private void configToolbar() {
        setSupportActionBar(toolbar);
    }

    private void configAdapter() {
        adapter = new ArtistaAdapter(new ArrayList<Artista>(), this);
    }

    private void configRecyclerView() {
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    /******
     *      Métodos implementados por la interface OnItemClickListener
     * ******/
    @Override
    public void onItemClick(Artista artista) {
        sArtista.setId(artista.getId());
        sArtista.setNombre(artista.getNombre());
        sArtista.setApellidos(artista.getApellidos());
        sArtista.setFechaNacimiento(artista.getFechaNacimiento());
        sArtista.setEstatura(artista.getEstatura());
        sArtista.setLugarNacimiento(artista.getLugarNacimiento());
        sArtista.setOrden(artista.getOrden());
        sArtista.setNotas(artista.getNotas());
        sArtista.setFotoUrl(artista.getFotoUrl());

        Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLongItemClick(Artista artista) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 1){
            adapter.add(sArtista);
        }
    }

    @OnClick(R.id.fab)
    public void addArtist() {
        Intent intent = new Intent(MainActivity.this, AddArtistActivity.class);
        intent.putExtra(Artista.ORDEN, adapter.getItemCount()+1);
        //startActivity(intent);
        startActivityForResult(intent, 1);
    }
}
