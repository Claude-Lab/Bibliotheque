/**
 * 
 */
package fr.lusseau.bibliotheque.service;

import java.util.List;

import fr.lusseau.bibliotheque.entity.Editor;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheque -v1,0
 * @date 17 oct. 2020 - 17:40:06
 * @author Claude LUSSEAU
 *
 */
public interface EditorService {

	public Editor saveEditor(Editor editeur);

	public Editor updateEditor(Editor editeur);

	public void deleteEditor(Integer idEditor);

	public List<Editor> findByNameContaining(String name);

	public boolean checkIfEditorExists(Integer idEditor);

}
