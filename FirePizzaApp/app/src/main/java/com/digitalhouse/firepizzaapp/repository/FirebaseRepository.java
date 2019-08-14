package com.digitalhouse.firepizzaapp.repository;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import io.reactivex.Completable;

public class FirebaseRepository {

    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    private static final String TAG = "FirebaseRepository";

    public Completable autenticar(String email, String senha) {
        return Completable.create(emitter -> {
            firebaseAuth.signInWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            emitter.onComplete();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            emitter.onError(task.getException());
                        }
                    });

        });
    }

}
