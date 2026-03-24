#include <stdio.h>
#include <stdlib.h>

struct Node{
    int data;
    struct Node *next;
};

int length(struct Node *head){
    int count = 0;
    struct Node *temp = head;

    while(temp != NULL){
        count++;
        temp = temp->next;
    }

    return count;
}

int main(){
    struct Node *head=NULL,*temp=NULL,*newNode;
    int data,choice;

    do{
        newNode=(struct Node*)malloc(sizeof(struct Node));

        printf("Enter number: ");
        scanf("%d",&data);

        newNode->data=data;
        newNode->next=NULL;

        if(head==NULL)
            head=temp=newNode;
        else{
            temp->next=newNode;
            temp=newNode;
        }

        printf("Add another node? (1=Yes 0=Exit): ");
        scanf("%d",&choice);

    }while(choice==1);

    printf("Length of Linked List = %d",length(head));
}