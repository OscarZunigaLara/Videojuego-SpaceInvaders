package mx.itesm.demo;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class PantallaMario extends Pantalla {

    private Juego juego;
    private TiledMap mapa;

    public PantallaMario(Juego juego){
        this.juego = juego;

    }

    private OrthogonalTiledMapRenderer rendererMapa;


    @Override
    public void show() {

        AssetManager manager = new AssetManager();

        manager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));

        manager.load("map/mapaMario.tmx", TiledMap.class);

        manager.finishLoading(); //


        mapa = manager.get("map/mapaMario.tmx");

        rendererMapa = new OrthogonalTiledMapRenderer(mapa);
    }

    @Override
    public void render(float delta) {

        borrarPantalla(1,0,0);

        rendererMapa.setView(camara);

        rendererMapa.render();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
